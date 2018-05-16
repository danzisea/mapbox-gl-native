package com.mapbox.mapboxsdk.maps;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mapbox.mapboxsdk.camera.CameraPosition;

public final class MapSettings extends ViewModel {
  private CameraPosition lastCameraPosition = CameraPosition.DEFAULT;
  private MutableLiveData<Double> maxZoom = new MutableLiveData<>();
  private MutableLiveData<Double> minZoom = new MutableLiveData<>();
  private MutableLiveData<Boolean> isDebugMode = new MutableLiveData<>();
  private MutableLiveData<Boolean> prefetchesTiles = new MutableLiveData<>();

  void initialiseOptions(@NonNull MapboxMapOptions options) {
    setLastCameraPosition(options.getCamera());
    setMinZoom(options.getMinZoomPreference());
    setMaxZoom(options.getMaxZoomPreference());
    setDebugMode(options.getDebugActive());
    setPrefetchesTiles(options.getPrefetchesTiles());
  }

  @Nullable
  public CameraPosition getLastCameraPosition() {
    return lastCameraPosition;
  }

  public void setLastCameraPosition(@Nullable CameraPosition lastCameraPosition) {
    this.lastCameraPosition = lastCameraPosition;
  }

  public double getMinZoom() {
    return minZoom.getValue();
  }

  public MutableLiveData<Double> getMinZoomObservable() {
    return minZoom;
  }

  public void setMinZoom(double minZoom) {
    this.minZoom.setValue(minZoom);
  }

  public double getMaxZoom() {
    return maxZoom.getValue();
  }

  public MutableLiveData<Double> getMaxZoomObservable() {
    return maxZoom;
  }

  public void setMaxZoom(double maxZoom) {
    this.maxZoom.setValue(maxZoom);
  }

  public MutableLiveData<Boolean> isDebugModeObservable() {
    return isDebugMode;
  }

  public boolean isDebugMode() {
    return isDebugMode.getValue();
  }

  public void setDebugMode(boolean isDebugMode) {
    this.isDebugMode.setValue(isDebugMode);
  }

  public MutableLiveData<Boolean> getPrefetchesTilesObservable() {
    return prefetchesTiles;
  }

  public boolean getPrefetchesTiles() {
    return prefetchesTiles.getValue();
  }

  public void setPrefetchesTiles(boolean prefetchesTiles) {
    this.prefetchesTiles.setValue(prefetchesTiles);
  }
}
