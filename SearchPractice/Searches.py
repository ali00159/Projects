
def get_wordlist():
    # Create empty list to add words too
    words = []
    # Open wordlist.txt to read
    f = open('wordlist.txt', 'r')
    # Read all of the text using the .read() function, this will be a string
    # then use the .split() function to split the string into a list of words
    # that are separated by the newline character
    for word in f.read().split('\n'):
        # Only add a word to the list if it is not an empty line
        if word:
            words.append(word)
    # Close the file
    f.close()

    return words


def starts_with(list_word, target_word):
    # if the target word is longer in length that the list word return false
    if len(target_word) > len(list_word):
        return False
    # use for loop to iteratite thru the indexes of the string target word and compare each value against the list word
    # if one of them isn't equal to the other return False otherwise return True
    for i in range(len(target_word)):
        if target_word[i] != list_word[i]:
            return False
    return True


def find_next_word_linear(word_list, target_word):
    for i in range(len(word_list)):
        if starts_with(word_list[i],target_word) == True:
            return word_list[i]
    else:
        return None


def find_next_word_binary(word_list, target_word):
    low = 0
    high = len(word_list) - 1
    #use a while loop to iterite thru the len of the word list
    while low <= high:
        #find the middle of the list and rounding it down
        mid = (low + high) // 2
        #comparing the value of the middle of the list against the target word if it is greater than set the new high to
        # mid
        if word_list[mid] > target_word:
            high = mid - 1
        # comparing the value of the middle of the list against the target word if it is less than set the new low to
        # mid
        elif word_list[mid] < target_word:
            low = mid + 1
        # if target value is the mid return the mid value
        else:
            return word_list[mid]
        
    if starts_with(word_list[mid], target_word):
        return word_list[mid]
    else:
        return None