![Header](http://gogreenyellow.com/github/saving-restoring-state/h_save_the_state2.png)

### The project has been created for the purposes of ['Saving/Restoring the App State'](http://gogreenyellow.com/articles/saving-restoring-state) article.

---

We've chosen the following typical scenarios to demonstrates the Android's behavior:
 - [Autosaving the View's state](https://github.com/gogreenyellow/SavingTheState#autosaving-the-views-state)
 - [Auto-managing Dialog state on lifecycle changes](https://github.com/gogreenyellow/SavingTheState#auto-managing-dialog-state-on-lifecycle-changes)
 - [Dynamically replaced Fragments](https://github.com/gogreenyellow/SavingTheState#dynamically-replaced-fragments)
 - [Fragments in a ViewPager](https://github.com/gogreenyellow/SavingTheState#fragments-in-a-viewpager)
 - [Collections](https://github.com/gogreenyellow/SavingTheState#collections)

---

## Autosaving the View's state 
[`com.gogreenyellow.savingthestate.autosaving`](https://github.com/gogreenyellow/SavingTheState/tree/master/app/src/main/java/com/gogreenyellow/savingthestate/autosaving)

The simplest case is autosaving demonstrated in this package.
It is shown on an example of the `ScrollView` which saves and restores its state automatically after adding an `id` to the 
view.


![Gif showing the auto-saving](http://gogreenyellow.com/github/saving-restoring-state/autosaving_W_opt.gif)  
  
  
## Auto-managing Dialog state on lifecycle changes
[`com.gogreenyellow.savingthestate.transientstate`](https://github.com/gogreenyellow/SavingTheState/tree/master/app/src/main/java/com/gogreenyellow/savingthestate/transientstate)

The usage of `TimePickerDialogFragment` in `TransientStateActivity` shows that it is worth to
use the `DialogFragments` instead of the simple `Dialogs` because the `FragmentManager` handles the 
lifecycle changes for us and the `DialogFragments` don't accidentally disappear when user rotates
the device or when the `Activity` is brought to background.


![Gif showing the Dialog Fragment](http://gogreenyellow.com/github/saving-restoring-state/dialog_W_opt.gif)


## Dynamically replaced Fragments
[`com.gogreenyellow.savingthestate.dynamicallyreplacedfragments`](https://github.com/gogreenyellow/SavingTheState/tree/master/app/src/main/java/com/gogreenyellow/savingthestate/dynamicallyreplacedfragments)

This package demonstrates that you 
don't have to manually save the displayed `Fragment` because the `FragmentManager` will handle that 
if you won't override the standard behavior. 


![Gif showing the dynamically replaced Fragments](http://gogreenyellow.com/github/saving-restoring-state/replaced_W_opt.gif)


## Fragments in a ViewPager
[`com.gogreenyellow.savingthestate.fragmentsinviewpager`](https://github.com/gogreenyellow/SavingTheState/tree/master/app/src/main/java/com/gogreenyellow/savingthestate/fragmentsinviewpager)

The example shows how to implement a `FragmentPagerAdapter` to avoid problems with showing the right `Fragment` after a lifecycle change.  


![Gif showing the Fragments in a ViewPager](http://gogreenyellow.com/github/saving-restoring-state/viewpager_W_opt.gif)


## Collections 
[`com.gogreenyellow.savingthestate.recycler`](https://github.com/gogreenyellow/SavingTheState/tree/master/app/src/main/java/com/gogreenyellow/savingthestate/recycler)

In this part of project you'll find a simple example which demonstrates how to persist the collection view's scroll position and user 
input when the displayed data is fetched asynchronously.


![Gif showing saving the collection state](http://gogreenyellow.com/github/saving-restoring-state/collection_W_opt.gif)
