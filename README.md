[![](https://jitpack.io/v/JuanArton/Android-ArcProgressBar.svg)](https://jitpack.io/#JuanArton/Android-ArcProgressBar)

# Description

Android library to create arc progress bar with features : ... Just see the screenshots and the xml code

# Screenshots
<img src="https://github.com/JuanArton/Android-ArcProgressBar/blob/main/Screenshots/Screenshot_1714917753.png?raw=true" width=25% height=25%> <img src="https://github.com/JuanArton/Android-ArcProgressBar/blob/main/Screenshots/Screenshot_1714917866.png?raw=true" width=25% height=25%> <img src="https://github.com/JuanArton/Android-ArcProgressBar/blob/main/Screenshots/Screenshot_1714917903.png?raw=true" width=25% height=25%>

<img src="https://github.com/JuanArton/Android-ArcProgressBar/blob/main/Screenshots/Screenshot_1714917918.png?raw=true" width=25% height=25%> <img src="https://github.com/JuanArton/Android-ArcProgressBar/blob/main/Screenshots/Screenshot_1714917945.png?raw=true" width=25% height=25%>

# How To Use
Add https://jitpack.io in settings.gradle.kts like this.
```
dependencyResolutionManagement {
       ..
        repositories {
            ..
            maven {
                setUrl("https://jitpack.io")
            }
        }
    }
```

Then, add dependencies
```
dependencies {
		implementation 'com.github.JuanArton:Android-ArcProgressBar:0.7'
}
```

# Attributes And Code
Attributes :
```
<com.juanarton.arcprogressbar.ArcProgressBar
        android:layout_width="200dp"
        android:layout_height="200dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:progress="70"
        app:progressMax="100"
        app:progressMin="0"
        app:progressColor="@color/red"
        app:trackColor="@color/black"
        app:startAngle="140"
        app:sweepAngle="260"
        app:trackWidth="10dp"
        app:progressWidth="10dp" />
```

Code (Kotlin) :
```
arcprogressbar.progress = 50f
arcprogressbar.progressColor = getColor(R.color.red)
arcprogressbar.trackColor = getColor(R.color.black)

```

# THANKYOU

