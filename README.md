# CoachMark
[![](https://jitpack.io/v/siscofran999/coachmark.svg)](https://jitpack.io/#siscofran999/coachmark)

The coachmark library is created to highlight your features.
I was inspired from https://github.com/chhatrasal09/CoachMark, but I adjusted it to fit my needs.

# Result
![](https://github.com/siscofran999/coachmark/blob/master/image/result.gif)

## Getting Starting
Add this in your root `settings.gradle.kts` file:
```gradle

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = java.net.URI("https://jitpack.io") }
    }
}
```

Then, add the library to your module `build.gradle.kts`
```gradle

dependencies {
    implementation("com.github.siscofran999:coachmark:version")
}

```

## Implement
```Kotlin
    val coachMarkSequence = CoachMarkSequence(this)
    coachMarkSequence.apply {
        addItem(
            binding.txvTop,
            getString(R.string.title_top),
            getString(R.string.lorem_ipsum_text)
        )
        addItem(
            targetView = binding.txvStartTop,
            title = getString(R.string.title_start_top),
            subTitle = getString(R.string.lorem_ipsum_text),
            gravity = Gravity.END_BOTTOM
        )
        addItem(
            targetView = binding.txvBottom,
            title = getString(R.string.title_bottom),
            subTitle = getString(R.string.lorem_ipsum_text),
            positiveButtonText = getString(R.string.label_btn_explore),
            skipButtonText = null
        )
        start(window?.decorView as ViewGroup)
        setOnFinishCallback {
            Toast.makeText(this@MainActivity,
                getString(R.string.label_finish), Toast.LENGTH_SHORT).show()
        }
    }
```

## License
```licence

Copyright 2023 Fransisco

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
```