This is a RelativeLayout containing a "LogoView" which can be used with text and/or icon which results a logo upon any image background. This library can be utilized for showing-off the photo, wallpaper or background using company or personal logo, copyright-sign or any text.

* [Installation](#installation)
* [Usage](#usage)
* [Samples](#samples)
* [Fonts](#fonts)

## installation

Grab via Maven

```
<dependency>
  <groupId>com.licon.logo</groupId>
  <artifactId>uilib</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```
Or

Add Gradle dependency:

```gradle
dependencies {
   compile 'com.licon.logo:uilib:1.0.0'
}
```

## usage

Xml
---

```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"

    <com.licon.logo.LogoView
        android:id="@+id/logoview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:logoHeight="40dp"
        app:logoWidth="80dp"
        app:logoText="Android"
        app:logoTypeface="Android_7.ttf"
        app:logoTextSize="36sp"
        app:logoTextColor="#79a717"
        app:logoMarginBottom="12dp"
        app:backgroundDrawable="@drawable/bg_android"/>

</RelativeLayout>
```
Java
-----
```
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;

import com.licon.logo.LogoView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogoView logoView = (LogoView) findViewById(R.id.logoview);
        logoView.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
    }
}
```

## samples

 ![](https://github.com/liconrepo/LogoView/blob/master/samples/device-2016-03-28-155040.png)
 ![](https://github.com/liconrepo/LogoView/blob/master/samples/device-2016-03-28-161024.png)
 ![](https://github.com/liconrepo/LogoView/blob/master/samples/device-2016-03-28-162349.png)

## fonts

There is a collection of fonts(typefaces) can be used as logo-text in xml descriptors.
Example:

```xml
app:logoTypeface="Roboto-Bold.ttf"
```
app:

1) Special Logo-Text: 28_Days_Later.ttf, Bleeding_Cowboys.ttf, HarryP.ttf, Trashbox.ttf, Twikling.otf, Android_7.ttf, Trashco.ttf, Waltograph42.otf)

2) OpenSans (OpenSans-CondBold.ttf, OpenSans-CondLight.ttf, OpenSans-CondLightItalic.ttf)

3) DroidSerif (droidserif_bold.ttf, droidserif_italic.ttf, droidserif_regular.ttf)

4) LiberationSerif (LiberationSerif-Bold.ttf, LiberationSerif-BoldItalic.ttf, LiberationSerif-Italic.ttf, LiberationSerif-Regular.ttf)

5) Roboto (Roboto-Bold.ttf, Roboto-Condensed.ttf, Roboto-Italic.ttf, Roboto-Light.ttf, Roboto-LightItalic.ttf, Roboto-Regular.ttf, Roboto-Thin.ttf, ThinItalicRoboto-.ttf)

src: http://www.urbanfonts.com/free-fonts.htm

Developer
---------

* [Khairul Alam Licon](https://github.com/liconrepo) (<licon.cseru10@gmail.com>)


License
--------

   Copyright 2016 Khairul Alam Licon

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.