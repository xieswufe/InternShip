def is_word_order(word_list, order):
    """Check whether the words in word_list is in order."""
    # Construct order Map
    order_map = {}
    for i, char in enumerate(order):
        order_map[char] = i

    # Compare word pairs
    for i in range(len(word_list) - 1):
        if not is_in_order(word_list[i], word_list[i + 1], order_map):
            return False
    return True

def is_in_order(word1, word2, order_map):
    """Check whetehr the word1 and word2 are in order."""
    for c1, c2 in zip(word1, word2):
        if c1 == c2:
            continue
        if order_map[c1] < order_map[c2]:
            return True
        else:
            return False
    return len(word1) <= len(word2)
