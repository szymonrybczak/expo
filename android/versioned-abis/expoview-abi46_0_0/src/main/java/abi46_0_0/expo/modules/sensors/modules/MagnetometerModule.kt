// Copyright 2015-present 650 Industries. All rights reserved.
package abi46_0_0.expo.modules.sensors.modules

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorManager
import android.os.Bundle
import abi46_0_0.expo.modules.interfaces.sensors.SensorServiceInterface
import abi46_0_0.expo.modules.interfaces.sensors.services.MagnetometerServiceInterface
import abi46_0_0.expo.modules.core.Promise
import abi46_0_0.expo.modules.core.interfaces.ExpoMethod

class MagnetometerModule(reactContext: Context?) : BaseSensorModule(reactContext) {
  override val eventName: String = "magnetometerDidUpdate"

  override fun getName(): String = "ExponentMagnetometer"

  override fun getSensorService(): SensorServiceInterface {
    return moduleRegistry.getModule(MagnetometerServiceInterface::class.java)
  }

  override fun eventToMap(sensorEvent: SensorEvent): Bundle {
    return Bundle().apply {
      putDouble("x", sensorEvent.values[0].toDouble())
      putDouble("y", sensorEvent.values[1].toDouble())
      putDouble("z", sensorEvent.values[2].toDouble())
    }
  }

  @ExpoMethod
  fun startObserving(promise: Promise) {
    super.startObserving()
    promise.resolve(null)
  }

  @ExpoMethod
  fun stopObserving(promise: Promise) {
    super.stopObserving()
    promise.resolve(null)
  }

  @ExpoMethod
  fun setUpdateInterval(updateInterval: Int, promise: Promise) {
    super.setUpdateInterval(updateInterval)
    promise.resolve(null)
  }

  @ExpoMethod
  fun isAvailableAsync(promise: Promise) {
    val mSensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val isAvailable = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null
    promise.resolve(isAvailable)
  }
}
