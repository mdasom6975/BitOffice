package com.bitoffice.web.drive;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpBackOffIOExceptionHandler;
import com.google.api.client.http.HttpBackOffUnsuccessfulResponseHandler;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.ExponentialBackOff;
import com.google.api.client.util.Sleeper;
import com.google.common.base.Preconditions;
import com.google.common.io.CharStreams;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class RetryHttpInitializerWrapper implements HttpRequestInitializer {

  private static final Logger LOG =
      Logger.getLogger(RetryHttpInitializerWrapper.class.getName());

  private final Credential wrappedCredential;

  private final Sleeper sleeper;

  public RetryHttpInitializerWrapper(Credential wrappedCredential) {
    this(wrappedCredential, Sleeper.DEFAULT);
  }

  RetryHttpInitializerWrapper(
      Credential wrappedCredential, Sleeper sleeper) {
    this.wrappedCredential = Preconditions.checkNotNull(wrappedCredential);
    this.sleeper = sleeper;
  }

  public void initialize(HttpRequest request) {
    final HttpUnsuccessfulResponseHandler backoffHandler =
        new HttpBackOffUnsuccessfulResponseHandler(
            new ExponentialBackOff())
            .setSleeper(sleeper);
    request.setInterceptor(wrappedCredential);

    request.setConnectTimeout(3 * 60000);  // 3 ºÐ Ä¿³Ø¼Ç Å¸ÀÓ¾Æ¿ô
    request.setReadTimeout(3 * 60000);  // 3 ºÐ ÀÐ±â Å¸ÀÓ¾Æ¿ô

    request.setUnsuccessfulResponseHandler(
        new HttpUnsuccessfulResponseHandler() {
          public boolean handleResponse(
              HttpRequest request,
              HttpResponse response,
              boolean supportsRetry) throws IOException {

            LOG.info("RetryHandler: " + CharStreams.toString(
                new InputStreamReader(response.getContent())));

            if (wrappedCredential.handleResponse(
                request, response, supportsRetry)) {

              LOG.info("Requested: " + request.getUrl().toString());
              return true;
            } else if (backoffHandler.handleResponse(
                request, response, supportsRetry)) {

              LOG.info("Retrying " + request.getUrl());
              return true;
            } else {
              return false;
            }
          }
        });
    request.setIOExceptionHandler(
        new HttpBackOffIOExceptionHandler(new ExponentialBackOff())
            .setSleeper(sleeper));
  }
}