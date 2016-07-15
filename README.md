#Java Config Reader

Configuration file name is configured with the following variable

```java
private final String file = "config.properties";
```

ConfigFileReader reads all items on this file and load them into "properties" object.

##Adding Config Items

Open config.properties files in a test editor

Add configuration items as below,

```html
PROPERTY1=PROPTERY1_VALUE
PROPERTY2=PROPTERY2_VALUE
PROPERTY3=PROPTERY3_VALUE
PROPERTY4=PROPTERY4_VALUE
.
.
PROPERTYn=PROPTERYn_VALUE
```

Please note, because this library loads all configuration items when it first gets a config item, any properties that are added won't be added until the configuration is reloaded.

##Reloading the Configuration

You can do this during the run time by calling the following method.

```java
config.reloadConfig();
```

Or you are able to reload the configuration from entirely different file during run time by calling the following method,

```java
config.reloadConfig("NEW_CONFIG_FILE");
```

##Accessing Config Items

This configuration items can be accesses as below,

```java
ConfigFileReader config = ConfigFileReader.getConfigFileReaderInstance();
config.getPropertyFor("CONFIG_ITEM");
```

This returns a String object.test










