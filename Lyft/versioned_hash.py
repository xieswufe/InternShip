# 1. versioned key value store
# 可以说是coding里面最简单的一道题了
# 实现以下 几个 api set(k, value), get(k), getValueWithVersion(k, version)
# 就是每set一次key（不管哪个key），version就increment一次。given a key and version, find the value, or if not version given, find the latest value
# use a hashtable + treeMap
from collections import defaultdict
class VersionedHashtable:
    def __init__(self):
        self.dict = defaultdict(dict)
        self.version = 0

    def set(self, key, value):
        self.dict[-1] = value
        self.dict[key][self.version] = value
        self.dict[key][-1] = value
        self.version += 1
        return self.version - 1

    def get(self, key):
        return self.dict[key][-1]

    def getValueWithVersion(self, key, version):
        return self.dict[key][version]

# Test cases
d = VersionedHashtable()
d.set(1, 2)
d.set(1, 3)
d.set(2, 4)
print(d.get(1))
print(d.getValueWithVersion(1, 0))
