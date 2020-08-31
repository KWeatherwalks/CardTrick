## Introduction
The program uses a process of logical deduction to pinpoint a user's secret card in a deck of 27 cards.

### Cards
The card images used in this program were found on the website http://www.jfitz.com/cards in April of 2015. The Wayback Machine has this archived at https://web.archive.org/web/20150506073516/jfitz.com/cards

## Graphical User Interface
### Main Menu
The main menu contains buttons for selecting various options. Only one of these features is active in this demo, the 27 Card Trick. The user may click the 27 Card Trick button to continue or exit the program by clicking the `X` in the upper-right corner or by pressing <kbd>Alt</kbd>+<kbd>Esc</kbd>.

![CardTrick Main Menu](https://github.com/KWeatherwalks/CardTrick/blob/main/demo/CardTrickMainMenu.png)

### Initialization
A 52 card deck is constructed, shuffled, and 25 cards are removed to form a deck consisting of 27 cards. The user is prompted to select a number from the drop-down list, memorize the rank and suit of one of the displayed cards, and then click on the <ins>N</ins>ext button. To continue, press <kbd>Alt</kbd>+<kbd>N</kbd>. To exit back to the main menu, click E<ins>X</ins>IT or press <kbd>Alt</kbd>+<kbd>X</kbd>.

![Pick a card and memorize it](https://github.com/KWeatherwalks/CardTrick/blob/main/demo/Initial.png)

### Round 1
The drop-down list is now locked on the chosen number. The 27 cards are shuffled and dealt out into 3 piles containing 9 cards each.

![Which pile is your card in?](https://github.com/KWeatherwalks/CardTrick/blob/main/demo/Round1.png)

The user is instructed to select the pile in which their memorized card  is located. For example, say the user's card is in the first pile. To select this pile, click the > Pile _1_  button or press <kbd>Alt</kbd>+<kbd>1</kbd>.

![You selected pile 1](https://github.com/KWeatherwalks/CardTrick/blob/main/demo/Round1wPileSelected.png)

### Rounds 2 and 3
The piles are rearranged into a single deck, according to an algorithm which depends on the user's chosen number and the pile that contains the user's card. The user is instructed to repeat the process performed in the first round for an additional two rounds.

![Which pile is your card in now?](https://github.com/KWeatherwalks/CardTrick/blob/main/demo/Round2wPileSelected.png)
![Which pile is your card in now?](https://github.com/KWeatherwalks/CardTrick/blob/main/demo/Round3wPileSelected.png)


## Final Screen
The piles are organized so that the user's card is the $n$-th card off the top of the deck, with $n$ being the number chosen at the start.

![Your card is the Jack of Hearts](https://github.com/KWeatherwalks/CardTrick/blob/main/demo/Magic.png)