
from Searches import starts_with, find_next_word_linear, find_next_word_binary, get_wordlist


assert starts_with("apple", "a") == True
assert starts_with("carrot", "car") == True
assert starts_with("a", "app") == False
assert starts_with("apple", "car") == False


words = ["apple", "banana", "grape", "pineapple", "tangerine"]

word = find_next_word_linear(words, "a")
assert word == "apple", f"Failed test: {word} should be apple"

word = find_next_word_linear(words, "app")
assert word == "apple", f"Failed test: {word} should be apple"

word = find_next_word_linear(words, "apr")
assert word == None, f"Failed test: {word} should be None"

word = find_next_word_linear(words, "band")
assert word == None, f"Failed test: {word} should be None"

word = find_next_word_linear(words, "tang")
assert word == "tangerine", f"Failed test: {word} should be tangerine"

word = find_next_word_linear(words, "car")
assert word == None, f"Failed test: {word} should be None"


words = get_wordlist()

word = find_next_word_linear(words, "acr")
assert word == "acre", f"Failed test: {word} should be acre"

word = find_next_word_linear(words, "kid")
assert word == "kid", f"Failed test: {word} should be kid"

word = find_next_word_linear(words, "tra")
assert word == "trace", f"Failed test: {word} should be trace"


# find_next_word_binary tests
words = ["apple", "banana", "grape", "pineapple", "tangerine"]

word = find_next_word_binary(words, "a")
assert word == "apple", f"Failed test: {word} should be apple"

word = find_next_word_binary(words, "app")
assert word == "apple", f"Failed test: {word} should be apple"

word = find_next_word_binary(words, "apr")
assert word == None, f"Failed test: {word} should be None"

word = find_next_word_binary(words, "band")
assert word == None, f"Failed test: {word} should be None"

word = find_next_word_binary(words, "tang")
assert word == "tangerine", f"Failed test: {word} should be tangerine"

word = find_next_word_binary(words, "car")
assert word == None, f"Failed test: {word} should be None"

# Test with the wordlist words
words = get_wordlist()

word = find_next_word_binary(words, "acr")
assert word == "acre", f"Failed test: {word} should be acre"

word = find_next_word_binary(words, "kid")
assert word == "kid", f"Failed test: {word} should be kid"

word = find_next_word_binary(words, "tra")
assert word == "trace", f"Failed test: {word} should be trace"


# If it all worked out
print("It worked!!!")
