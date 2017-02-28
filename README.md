# MagicFragmentLibrary
[![](https://jitpack.io/v/AleksandarMarinkovic/MagicFragmentLibrary.svg)](https://jitpack.io/#AleksandarMarinkovic/MagicFragmentLibrary)
Installing
--------

You can use the gradle dependency, you have to add these lines in your build.gradle file:

```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
and:
```groovy
dependencies {
	        compile 'com.github.AleksandarMarinkovic:MagicFragmentLibrary:1.0'
	}
```
## How do I implement it?

#### 1.Initialize 
Create a list of fragments and pass them in
```groovy
 FragmentOrganizer fragmentOrganizer = new FragmentOrganizer(getSupportFragmentManager(), BlankFragment.class);
 //import first fragment.
        ArrayList<Class> ContainerFragments = new ArrayList<>();
        ContainerFragments.add(BlankFragment.class);
        ContainerFragments.add(BlankFragment1.class);
        fragmentOrganizer.setUpContainer(R.id.wraper, ContainerFragments);
	
	
```
OR Set in Container without back stack
```groovy 
fragmentOrganizer.setUpContainer(R.id.wraper, ContainerFragments,true);
```
#### 2.Put a fragment(Replace fragment)
```groovy
 fragmentOrganizer.putFragment(BlankFragment.class);
```


## Apps Using My Library
Feel free to send me a pull request with your app and I'll link you here:

## Contributions
If you have any problems, feel free to create an issue or pull request.
## LICENSE

Copyright (c) 2016-present, Aleksandar Marinkovic.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

<http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
