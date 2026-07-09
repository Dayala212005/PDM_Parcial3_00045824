package com.pdm0126.parcial3

import android.app.Application
import com.pdm0126.parcial3.data.AppProvider

class RankeUca : Application() {
    val appProvider: AppProvider by lazy { AppProvider(this) }
}