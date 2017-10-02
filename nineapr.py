import numpy as np
import matplotlib.pyplot as plt
from scipy.integrate import simps
from numpy import trapz

x=[]
y=[]
# Create data
for i in range(0,11):
    print("enter the no of positive values below threshold")
    bpthresh=int(input())

    print("enter the no of negative values below threshold")
    bnthresh=int(input())*10

    print("enter the no of positive values above threshold")
    apthresh=int(input())

    print("enter the no of negative values above threshold")
    anthresh=int(input())*10

    Recall = apthresh/(apthresh + bpthresh)

    if(apthresh == 0 and (apthresh+anthresh) == 0):
        Precision=1
    else:
        Precision = apthresh/(apthresh+anthresh)



    x.append(Recall);
    y.append(Precision);

    #x=[1.0, 1.0, 0.8, 0.8, 0.8, 0.6, 0.6, 0.4, 0.2, 0.2]
    #y=[0.009900990099009901, 0.012345679012345678, 0.009900990099009901, 0.013157894736842105, 0.0196078431372549, 0.014778325123152709, 0.02912621359223301, 0.0196078431372549, 0.009900990099009901, 1.0]

    print(x)
    print(y)
    print("--------------------------------------------------------------------------------------")



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
print("Area under the  PR curve is: ")
print(area)
