# Mobile testing

## Installation 

### Here are the steps to install Appium on a macOS machine:

1. Install Homebrew:

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
```

2. Install Node.js:

```bash
brew install node
```

3. Install Appium:

```bash
npm install -g appium
```

4. Verify the installation:
```bash
appium
```

### Here are the steps to install Appium on a Windows machine:

1. Install Node.js:
Download and install the latest version of Node.js from the official website (https://nodejs.org/en/download/). 

2. Install Appium: 

```bash
npm install -g appium
```

3. Verify the installation:

```bash
appium
```

## Install Android Studio on a Windows machine:
1. Link - https://developer.android.com/studio 
2. Download SDK platform tools -  https://developer.android.com/studio/releases/platform-tools
3. Add ANDROID_HOME, JAVA_HOME, ADB in Environment Variables on Windows 
4. If you are using real device enable the developer options setting - https://motorola-global-en-uk.custhelp.com/app/answers/detail/a_id/159678/~/developer-options 
5. Check the list of all devices

```bash
adb devices
```

## How to Download & Install UIAutomator(on Windows)
“Uiautomatorviewer” is a part of the Android SDK manager and will be accessible once you install the SDK manager.

Once Android SDK installed, navigate to link

1. Open the terminal and run those commands
```bash
cd c:\users\<username>\AppData\Local\Android\sdk\tools\bin
```

2. You’ll notice a batch file with name/ run it 

```bash
uiautomatorviewer.bat
```
3. Connect your android device to PC via USB cable

4. Select “your_app” app from applications

5. Click the ‘Device screenshot’ button to refresh the “Uiautomatorviewer” and 
to load the your_app application GUI on “Uiautomatorviewer”

6. As you see in the above image, on the right side of the window there are 2 panels.
Upper panel contains node hierarchy the way the UI components are arranged and contained,
clicking on each node gives properties of UI elements in the lower panel

