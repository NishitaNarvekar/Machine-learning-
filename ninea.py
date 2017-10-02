import numpy as np
import matplotlib.pyplot as plt
from scipy.integrate import simps
from numpy import trapz

x=[]
y=[]
# Create data
for i in range(0,11):
    print("enter the no of positive values below threshold")
    #bpthresh=int(input())

    print("enter the no of negative values below threshold")
    #bnthresh=int(input())*10

    print("enter the no of positive values above threshold")
    #apthresh=int(input())

    print("enter the no of negative values above threshold")
    #anthresh=int(input())*10

    #TPR = apthresh/(apthresh + bpthresh)

    #TNR = bnthresh/(bnthresh+anthresh)

    #FPR=1-TNR

    #x.append(FPR);
    #y.append(TPR);

    x1=[1.0, 0.8, 0.8, 0.6, 0.4, 0.4, 0.19999999999999996, 0.19999999999999996, 0.19999999999999996, 0.0,0.0]
    y1 = [1.0, 1.0, 0.8, 0.8, 0.8, 0.6, 0.6, 0.4, 0.2, 0.2,0.0]

    print(x1)
    print(y1)

    print("--------------------------------------------------------------------------------------")



# Plot


plt.scatter(x1, y1)
plt.plot(x1, y1)
plt.title('ROC')
plt.xlabel('FPR')
plt.ylabel('TPR')
plt.ylim(ymin=0,ymax=1)
plt.xlim(xmin=0,xmax=1)
plt.show()
area=trapz(x1,y1)
print("Area Under the  ROC curve is: ")
print(1+area)
