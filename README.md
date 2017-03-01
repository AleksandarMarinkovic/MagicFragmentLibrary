# MagicFragmentLibrary
[![](https://jitpack.io/v/AleksandarMarinkovic/MagicFragmentLibrary.svg)](https://jitpack.io/#AleksandarMarinkovic/MagicFragmentLibrary)
--------
Android library for managing multiple stacks of fragments. 

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
	       compile 'com.github.AleksandarMarinkovic:MagicFragmentLibrary:1.1'
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
OR with arrgument
```groovy
 FragmentEvent fragmentEvent = new FragmentEvent(BlankFragment.class)
 fragmentOrganizer.putFragment(fragmentEvent,"Text");


//Get arrgument in fragment 
getArguments().getString("PRIMARY_ARG_TAG");

```

### Helper functions

Manually Back Navigation 
return true and flase
```groovy
fragmentOrganizer.handleBackNavigation()  
```
Get open Fragmnet
```groovy
fragmentOrganizer.getOpenFragment(){
```  
Set Animations 
```groovy
fragmentOrganizer.setAnimations(enter,exit,popEnter,popExit)
```
#### It is not necessary 
Create BasicFragment
```groovy
public abstract class BaseFragment extends Fragment {
    public static final String PRIMARY_ARG_TAG = "PRIMARY_ARG_TAG";
    private static final String TAG = "Base Fragment";
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    Object data;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    protected boolean hasPrimaryArgument(){
        return null!=getArguments().getString(BaseFragment.PRIMARY_ARG_TAG);
    }
    protected String getPrimaryArgument(){
        return getArguments().getString(BaseFragment.PRIMARY_ARG_TAG);
    }
}
```
```groovy
public class MyFragment extends BaseFragment
```
## Apps Using My Library
Feel free to send me a pull request with your app and I'll link you here:

## Contributions
If you have any problems, feel free to create an issue or pull request.
## LICENSE

Copyright (c) 2017-present, Aleksandar Marinkovic.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

<http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
