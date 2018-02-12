![Header](http://gogreenyellow.com/github/saving-restoring-state/h_save_the_state.png)

This repository demonstrates how to save and restore the application's state in some typical 
scenarios.  

### Autosaving the View's state 

Demonstrated in `com.gogreenyellow.savingthestate.autosaving` package. It is shown on an example 
of the `ScrollView` which saves and restores its state automatically after adding an `id` to the 
view.

![Gif showing the auto-saving](http://gogreenyellow.com/github/saving-restoring-state/autosaving_W_opt.gif)  
  
### Saving the user input 

Shown on an example of time picked by the user in `com.gogreenyellow.savingthestate.transientstate` 
package. The `TransientStateActivity` saves the user input with `onSaveInstanceState()` and restores
it from a `Bundle`.

![Gif showing the manual saving](http://gogreenyellow.com/github/saving-restoring-state/dialog_W_opt.gif)  

### Auto-managing Dialog state on lifecycle changes

The usage of `TimePickerDialogFragment` in `TransientStateActivity` shows that it is worth to
use the `DialogFragments` instead of the simple `Dialogs` because the `FragmentManager` handles the 
lifecycle changes for us and the `DialogFragments` don't accidentally disappear when user rotates
the device or when the `Activity` is brought to background.

![Gif showing the Dialog Fragment](http://gogreenyellow.com/github/saving-restoring-state/dialog_W_opt.gif)

### Dynamically replaced Fragments

The `com.gogreenyellow.savingthestate.dynamicallyreplacedfragments` package demonstrates that you 
don't have to manually save the displayed `Fragment` because the `FragmentManager` will handle that 
if you won't override the standard behavior. 

![Gif showing the dynamically replaced Fragments](http://gogreenyellow.com/github/saving-restoring-state/replaced_W_opt.gif)


### Fragments in a ViewPager

The `com.gogreenyellow.savingthestate.fragmentsinviewpager` shows how to implement a 
`FragmentPagerAdapter` to avoid problems with showing the right `Fragment` after a lifecycle change.  

![Gif showing the Fragments in a ViewPager](http://gogreenyellow.com/github/saving-restoring-state/viewpager_W_opt.gif)

### Collections 

A simple example which demonstrates how to persist the collection view's scroll position and user 
input when the displayed data is fetched asynchronously.

![Gif showing saving the collection state](http://gogreenyellow.com/github/saving-restoring-state/collection_W_opt.gif)