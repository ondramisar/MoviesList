object Version {
    const val appCompat = "1.0.2"
    const val supportV4 = "1.0.0"
    const val supportDesign = "1.0.0"
    const val supportCardView = "1.0.0"
    const val supportRecyclerView = "1.0.0"
    const val supportCore = "1.0.2"

    const val roomVersion = "2.1.0"

    const val lifecycle = "1.1.1"

    const val constraintVersion = "1.1.3"

    const val kotlinVersion = "1.3.40"

    const val playServicesVersion = "17.0.0"

    const val glideVersion = "4.9.0"
    const val glideIntegration = "4.9.0"

    const val workVersion = "1.0.1"

    const val koinVersion = "2.0.1"

    const val robolectricVersion = "4.3"

    const val retrofit = "2.4.0"
    const val gson = "2.1.0"

    const val rxAndroid = "2.1.1"
    const val rxJava = "2.2.10"
    const val rxBinding = "2.2.0"

    const val buildGradle = "3.4.1"

    const val daggerVersion = "2.16"
    const val javaxAnnotation = "3.1.1"

    const val pagingVersion = "2.1.0"
}

object SupportLibraries {
    val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    val support = "androidx.legacy:legacy-support-v4:${Version.supportV4}"
    val design = "com.google.android.material:material:${Version.supportDesign}"
    val cardView = "androidx.cardview:cardview:${Version.supportCardView}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Version.supportRecyclerView}"
    val core = "androidx.core:core-ktx:${Version.supportCore}"
}

object Glide {
    val glide = "com.github.bumptech.glide:glide:${Version.glideVersion}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glideVersion}"
    val glideIntegration = "com.github.bumptech.glide:okhttp3-integration:${Version.glideIntegration}"
}

object Lifecycle {
    val extension = "android.arch.lifecycle:extensions:${Version.lifecycle}"
    val viewModel = "android.arch.lifecycle:viewmodel:${Version.lifecycle}"
    val reactiveStreams = "android.arch.lifecycle:reactivestreams:${Version.lifecycle}"
}

object Retrofit {
    val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    val rxjavaRetrofit = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofit}"
    val retrofitConverter = "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Version.gson}"
}

object Room {
    val roomRuntime = "androidx.room:room-runtime:${Version.roomVersion}"
    val roomCompiler = "androidx.room:room-compiler:${Version.roomVersion}"
    val roomRxjava = "androidx.room:room-rxjava2:${Version.roomVersion}"
    val roomQuava = "androidx.room:room-guava:${Version.roomVersion}"
}

object Rxjava {
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
    val rxJava = "io.reactivex.rxjava2:rxjava:${Version.rxJava}"
    val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Version.rxBinding}"
}

object Kotlin {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlinVersion}"
    val kotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
}

object Dagger2 {
    val dagger = "com.google.dagger:dagger:${Version.daggerVersion}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.daggerVersion}"
    val javaxAnnotation = "org.glassfish:javax.annotation:${Version.javaxAnnotation}"
}

object Paging {
    val paging = "androidx.paging:paging-runtime:${Version.pagingVersion}"
    val rxPaging = "androidx.paging:paging-rxjava2:${Version.pagingVersion}"
}

object Koin {
    val koinAndroid = "org.koin:koin-android:${Version.koinVersion}"
    val koinScope = "org.koin:koin-androidx-scope:${Version.koinVersion}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Version.koinVersion}"
}

object ViewsLibraries {
    val instaDotView = "com.github.hrskrs:InstaDotView:1.1"
    val photoView = "com.github.chrisbanes:PhotoView:2.3.0"
    val indefinitePagerIndicator = "com.ryanjeffreybrooks:indefinitepagerindicator:1.0.10"
    val youtubePlayer = "com.pierfrancescosoffritti.androidyoutubeplayer:core:8.0.1"
    val snackbar = "com.nispok:snackbar:2.11.0"
    val roundCornerProgressBar = "com.akexorcist:RoundCornerProgressBar:2.0.3"
    val customGauge = "pl.pawelkleczkowski.customgauge:CustomGauge:1.0.4"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintVersion}"
    val simpleBarcodeScanner = "com.github.bobekos:SimpleBarcodeScanner:1.0.19"
    val edittextField = "com.poovam:pin-edittext-field:1.2.1"
    val crystalRangeSeekbar = "com.crystal:crystalrangeseekbar:1.1.3"
}

object BuildGradle {
    val buildGradle = "com.android.tools.build:gradle:${Version.buildGradle}"
}

object TestingLibraries {
    val junit = "junit:junit:4.12"
    val core = "androidx.test:core:1.0.0"
    val testRunner = "androidx.test:runner:1.2.0"
    val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
    val roomTest = "androidx.room:room-testing:${Version.roomVersion}"
    val robolectric = "org.robolectric:robolectric:${Version.robolectricVersion}"
}