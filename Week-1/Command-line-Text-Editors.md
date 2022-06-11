# Command-line Text Editors

## Vi/Vim

Vi originally came from the word "visual" as it was an early attempt at a more visual text editor. In order to use Vi, you can run `vi file-path`, and it will open in your terminal. Vi is set up such that there are two main "modes" that you can switch between - command mode and insert mode. When you first open Vi, you start in command mode, where you will be unable to type anything into the file. You can delete, copy, cut, paste, and undo, however, using the following commands:

- `x` to delete the character under the cursor.
- `dd` to delete the current line.
- `v` to mark the starting point of text you want to copy or cut.
- `y` to copy anything between the cursor and the place where you typed `v`.
- `x` to cut anything between the cursor and the place where you typed `v`.
- `p` to paste.
- `u` to undo.

After pressing `i` in command mode, you will switch to insert mode, where you can freely type in your file. After you've typed whatever you want to type, you can use the `esc` key to go back to command mode, and use any of the following commands:

- `:w` to save.
- `:q` to quit without saving.
- `:wq` to save and quit.
- `:q!` to force quit (if you've made changes that you don't want to save).

Vim is short for "Vi IMproved", and it is simply an improved version of Vi. You can use it by running `vim file-path`. Some of the improvements that were made include the ability to undo more than one action, open multiple windows, and more.

Vi/Vim are liked because they make complex text edits easy and fast. Once you get comfortable with the commands and switching between modes, it's a quick, light tool, great for performing for complex edits efficiently, although there is more of a learning curve.

## Nano

Open a file using Nano by running `nano file-path`. A key feature of Nano is that it shows you a list of useful commands right at the bottom of the terminal which makes it easy to use, especially for beginners. Most commands use the `CTRL` key, marked by `^` in the list. For example, pressing `CTRL+G` (Get Help) will show all commands.

Unlike Vi/Vim, Nano does not feature different modes - insertion and commands can both be done without needing to switch anything. This, along with the list of commands on the bottom, make the editor easy to use, especially for beginners and/or those who are more accustomed to modern GUI text editors.