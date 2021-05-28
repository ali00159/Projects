
import time
from Searches import find_next_word_linear, find_next_word_binary, get_wordlist

words = get_wordlist()
start = time.time()
find_next_word_linear(words, "abandoned")
end = time.time()
print(f"Linear abandoned: {end - start} seconds")

words = get_wordlist()
start = time.time()
find_next_word_linear(words, "language")
end = time.time()
print(f"Linear language: {end - start} seconds")


start = time.time()
find_next_word_linear(words, "zealand")
end = time.time()
print(f"Linear zealand: {end - start} seconds")

words = get_wordlist()
start = time.time()
find_next_word_binary(words, "abandoned")
end = time.time()
print(f"Binary abandoned: {end - start} seconds")

words = get_wordlist()
start = time.time()
find_next_word_binary(words, "language")
end = time.time()
print(f"Binary language: {end - start} seconds")

words = get_wordlist()
start = time.time()
find_next_word_binary(words, "zealand")
end = time.time()
print(f"Binary zealand: {end - start} seconds")