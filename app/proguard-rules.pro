# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Preserve line numbers for Google Play Console automatic crash deobfuscation
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# Room Database reflection target (QuizDatabase_Impl lookup by Room.databaseBuilder)
-keep class * extends androidx.room.RoomDatabase {
    <init>(...);
}
-dontwarn androidx.room.paging.**

# WorkManager ListenableWorker constructors instantiated via reflection
-keep class * extends androidx.work.ListenableWorker {
    public <init>(android.content.Context, androidx.work.WorkerParameters);
}

# Jetpack Credential Manager & Google Sign-In (loaded via reflection in Play Services provider)
-keep class androidx.credentials.playservices.** { *; }
-keep class * implements androidx.credentials.CredentialProvider {
    public <init>(android.content.Context);
}
-keep class com.google.android.libraries.identity.googleid.** { *; }
-keepclassmembers class com.google.firebase.auth.** { *; }


