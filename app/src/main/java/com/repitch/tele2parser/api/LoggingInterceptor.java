package com.repitch.tele2parser.api;

import com.google.common.base.Charsets;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import timber.log.Timber;

/**
 * Created by repitch on 20.01.2018. (original by chelombitko)
 */
public class LoggingInterceptor implements Interceptor {
    private static final String LOG_TAG = "Network";
    private static final long MAX_PRINTABLE_BODY_SIZE = 1024;
    private static final List<String> PRINTABLE_CONTENT_TYPES = Arrays.asList(
            "text/plain",
            "text/html",
            "text/xml",
            "application/json",
            "application/x-www-form-urlencoded");

    @Override
    public Response intercept(Chain chain) throws IOException {
        final Request request = chain.request();
        Timber.tag(LOG_TAG).d("--> %s %s", request.method(), request.url());
        logBody(request.body());
        final long startNs = System.nanoTime();
        final Response response = chain.proceed(request);
        final long elapsedNs = System.nanoTime() - startNs;
        Timber.tag(LOG_TAG).d("<-- %s %s (%d ms)", request.method(), request.url(), TimeUnit.NANOSECONDS.toMillis(elapsedNs));
        logBody(response.body());
        return response;
    }

    private void logBody(RequestBody body) throws IOException {
        if (body == null) {
            return;
        }
        final long contentLength = body.contentLength();
        final MediaType contentType = body.contentType();
        if (contentLength > 0 && contentLength < MAX_PRINTABLE_BODY_SIZE && isPrintable(contentType)) {
            final Buffer buffer = new Buffer();
            body.writeTo(buffer);

            final Charset charset = contentType.charset(Charsets.UTF_8);
            Timber.tag(LOG_TAG).d(buffer.readString(charset));
        }
    }

    private void logBody(ResponseBody body) throws IOException {
        final long contentLength = body.contentLength();
        final MediaType contentType = body.contentType();
        if (contentLength > 0 && contentLength < MAX_PRINTABLE_BODY_SIZE && isPrintable(contentType)) {
            final BufferedSource source = body.source();
            source.request(Long.MAX_VALUE);
            final Buffer buffer = source.buffer();

            final Charset charset = contentType.charset(Charsets.UTF_8);
            Timber.tag(LOG_TAG).d(buffer.clone().readString(charset));
        }
    }

    private boolean isPrintable(MediaType contentType) {
        if (contentType == null) {
            return false;
        }
        final String typeSubtype = contentType.type() + "/" + contentType.subtype();
        return PRINTABLE_CONTENT_TYPES.contains(typeSubtype);
    }
}

