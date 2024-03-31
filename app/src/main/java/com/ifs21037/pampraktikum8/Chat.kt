package com.ifs21037.pampraktikum8

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Chat(
    var kontak: String,
    var icon: Int

    ) : Parcelable