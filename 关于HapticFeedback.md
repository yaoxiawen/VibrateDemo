performHapticFeedback震动反馈不需要震动权限。

#### HapticFeedbackEnabled
- HapticFeedbackEnabled默认是true。
- 只有在HapticFeedbackEnabled为true的情况下，才会触发震动反馈。
- 在xml里，可以通过android:hapticFeedbackEnabled=”false|true”来进行设置。
- 在Java代码里，可以通过view.setHapticFeedbackEnabled(boolean)来设置。

#### HapticFeedbackConstants
常量值有三个：LONG_PRESS（长按），FLAG_IGNORE_VIEW_SETTING（不受view的设置影响，即不受HapticFeedbackEnabled的影响），FLAG_IGNORE_GLOBAL_SETTING（不受系统设置的影响，即不受是否开启震动反馈的影响）。

受到view的设置影响和系统设置影响：

```
v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
```

不受view的设置影响，受到系统设置影响：

```
v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
```

不受view的设置影响和系统设置影响，可能用户体验会不大好：

```
v.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
```
