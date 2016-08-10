# RxMVP - Easy to use Reactive MVP library

[![Build Status](https://travis-ci.org/Seishin/rxmvp-android.svg?branch=master)](https://travis-ci.org/Seishin/rxmvp-android)

Basic usage
----
1. Extend your activity with lib's RxActivity:
	```java
public class MainActivity extends RxActivity<MainPresenter> {
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Create and set your presenter
        setPresenter(new MainPresenter(this));
    }
}
```
    
2. Create your MainPresenter:
	```java
public class MainPresenter extends RxPresenter<MainActivity, MainDataModel> {
    
    public MainPresenter(MainActivity view) {
        super(view);
        
        // Create and set your data model
        setModel(new MainDataModel());
    }
}
```
    
3. Create your MainDataModel:
	```java
public class MainDataModel implements RxModel {
}
```
    
That is all! 

Using the EventBus
-----
If you want to use lib's event bus, just send an event with:

```java
getEventBus().sendEvent(new SampleEvent());
```

For more info, see the RxBus repo:
[RxBus](https://github.com/Seishin/rxbus-android)

Contribution
-----
Everyone is welcomed to contribute on this project! :)