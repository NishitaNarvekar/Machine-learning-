import numpy as np
import matplotlib.pyplot as plt
from scipy.integrate import simps
from numpy import trapz

# Create data

x = [1,1,0.8,0.8,0.8,0.6,0.6,0.4,0.2,0.2,0]
y = [0.5,0.55,0.5,0.57,0.667,0.6,0.75,0.667,0.5,1,1]

# Plot

plt.scatter(x, y)
plt.plot(x, y)
plt.title('PR curve')
plt.xlabel('Recall')
plt.ylabel('Precision')
plt.ylim(ymin=0,ymax=1)
plt.xlim(xmin=0,xmax=1)
plt.show()

area=trapz(x,y)
print("Area Under the curve is: ")
print(1-area)
