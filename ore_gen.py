class prob:
    def sample(self, x):
        pass
class trap(prob):
    def __init__(self, start, end, mul):
        self.start = start
        self.end = end
        self.mul = mul
    def sample(self, x):
        end = self.end + 1
        start = self.start - 1
        mid = (start + end) / 2
        return (((end - mid) - abs(mid -x))/((end - mid) * (end - mid)))*self.mul
    def __repr__(self):
        return "trap["+str(self.start)+", "+str(self.end)+"], "+str(self.mul)
class uni(prob):
    def __init__(self, start, end, mul):
        self.start = start
        self.end = end
        self.mul = mul
    def sample(self, x):
        return self.mul/(self.end - self.start)
    def __repr__(self):
        return "uni["+str(self.start)+", "+str(self.end)+"], "+str(self.mul)
import numpy as np
world_start = -64
world_end = 319
world_range = world_end - world_start
world_range += 10
distribution = [["coal", [ \
uni(136, world_end, 30), \
trap(0, 192, 20) \
], np.zeros(world_range) \
],["copper", [ \
trap(-16, 112, 16), \
trap(-16, 112, 32), \
], np.zeros(world_range) \
],["gold", [ \
uni(32, 256, 50), \
trap(-64, 32, 4), \
uni(-64, -48, 2) \
], np.zeros(world_range) \
],["iron", [ \
trap(80, 384, 90), \
trap(-24, 56, 10), \
uni(world_start, 72, 10) \
], np.zeros(world_range) \
],["lapis", [ \
trap(-32, 32, 2), \
uni(world_start, 64, 4) \
], np.zeros(world_range) \
],["redstone", [ \
uni(world_start, 15, 4), \
trap(-32, 32, 8), \
], np.zeros(world_range) \
],["diamond", [ \
trap(-80, 80, 7*1.36), \
trap(-80, 80, 4) \
], np.zeros(world_range) \
]
]
for ore in distribution:
    for prob in ore[1]:
        s = prob.start if prob.start >= world_start else world_start
        e = prob.end if prob.end <= world_end else world_end
        for level in range(s,e+1):
            p = prob.sample(level)
            ore[2][level+64] += p
oremap=[["level"]]
for ore in range(len(distribution)):
    oremap[0].append(distribution[ore][0])
for level in range(len(distribution[0][2])):
    if level-64 >= world_start and level-64 <= world_end:
        c_level = [level-64]
        for ore in range(len(distribution)):
            c_level.append(round(distribution[ore][2][level]*10000))
        oremap.append(c_level)
import csv
with open("genmap.csv", "w", newline="") as f:
    writer = csv.writer(f)
    writer.writerows(oremap)