Snowball Android Design Library <br> [ ![Download](https://api.bintray.com/packages/aquarids/maven/design/images/download.svg?version=0.1.1) ](https://bintray.com/aquarids/maven/design/0.1.1/link)
============

Make it easier to collect & analytic data with different third party service.

## Installation

```groovy
dependencies {
    // add dependency, please replace x.y.z to the latest version
    implementation "com.xueqiu.eventlogger:eventlogger:x.y.z"
    // if you use umeng analytics
    implementation "com.xueqiu.eventlogger:umeng:x.y.z"
}
```

## Usage

Before you use the library, please read relevant documents.
- [Umeng](https://developer.umeng.com/docs/119267/detail/118578)

Initialize the ELog in the proper place.

```kotlin
 val options = EventLogOptions()
    .isDebug(BuildConfig.DEBUG)
    .withLogger(xxxLogger)
ELog.init(this, options)
```

Then create the event.

```kotlin
val event = LogEvent(category, action, target, page, source)
event.extra = mExtra
ELog.log(this, event)
```

### Umeng

Register the umeng analytics.
```kotlin
withHandler(UmengEventLogger(umengAppKey, installChannel))
```

## Proguard

Umeng:
```
-keep class com.umeng.** {*;}
```

For more details, please read the example or source code.
