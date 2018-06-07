package net.ijichi.zaifvirtualcurrency.api.model.extension

import android.content.Context
import android.content.pm.PackageInfo

val Context.packageInfo: PackageInfo
    get() = packageManager.getPackageInfo(packageName, 0)

val Context.versionCode: Int
    get() = packageInfo.versionCode

val Context.versionName: String
    get() = packageInfo.versionName