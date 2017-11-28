import numpy as np
from sklearn.cluster import DBSCAN
import matplotlib.pyplot as pl
from sklearn.decomposition import PCA

X=[[1.0,5.0],[1.25,5.35],[1.25,5.75],[1.5,6.25],[1.75,6.75],[2.0,6.5],[3.0,7.75],[3.5,8.25],[3.75,8.75],[3.95,9.1],[4.0,8.5],[2.5,7.25],[2.25,7.75],[2.0,6.5],[2.75,8.25],[4.5,8.9],[9.0,5.0],[8.75,5.85],[9.0,6.25],[8.0,7.0],[8.5,6.25],[8.5,6.75],[8.25,7.65],[7.0,8.25],[6.0,8.75],[5.5,8.25],[5.25,8.75],[4.9,8.75],[5.0,8.5],[7.5,7.75],[7.75,8.25],[6.75,8.0],[6.25,8.25],[4.5,8.9],[5.0,1.0],[1.25,4.65],[1.25,4.25],[1.5,3.75],[1.75,3.25],[2.0,3.5],[3.0,2.25],[3.5,1.75],[3.75,8.75],[3.95,0.9],[4.0,1.5],[2.5,2.75],[2.25,2.25],[2.0,3.5],[2.75,1.75],[4.5,1.1],[5.0,9.0],[8.75,5.15],[8.0,2.25],[8.25,3.0],[8.5,4.75],[8.5,4.25],[8.25,3.35],[7.0,1.75],[8.0,3.5],[6.0,1.25],[5.5,1.75],[5.25,1.25],[4.9,1.25],[5.0,1.5],[7.5,2.25],[7.75,2.75],[6.75,2.0],[6.25,1.75],[4.5,1.1],[3.0,4.5],[7.0,4.5],[5.0,3.0],[4.0,3.35],[6.0,3.35],[4.25,3.25],[5.75,3.25],[3.5,3.75],[6.5,3.75],[3.25,4.0],[6.75,4.0],[3.75,3.55],[6.25,3.55],[4.75,3.05],[5.25,3.05],[4.5,3.15],[5.5,3.15],[4.0,6.5],[4.0,6.75],[4.0,6.25],[3.75,6.5],[4.25,6.5],[4.25,6.75],[3.75,6.25],[6.0,6.5],[6.0,6.75],[6.0,6.25],[5.75,6.75],[5.75,6.25],[6.25,6.75],[6.25,6.25],[9.5,9.5],[2.5,9.5],[1.0,8.0]]
data=np.asarray(X)
dbscan = DBSCAN(eps=2, min_samples=10)
dbscan.fit(data)
pca = PCA(n_components=2).fit(data)
pca_2d = pca.transform(data)

cnt1=cnt2=cnt3=cnt4=cnt5=cnt6=cnt7=cnt8=cnt9=cnt10=cnt11=cnt12=0
for i in range(0, pca_2d.shape[0]):
	if dbscan.labels_[i] == -1:
		c1 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='r',marker='x')
		cnt1=cnt1+1
	elif dbscan.labels_[i] == 0:
		c2 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='g',marker=(8, 2))
		cnt2=cnt2+1
	elif dbscan.labels_[i] == 1:
		c3 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='b',marker=(8, 2))
		cnt3=cnt3+1
	elif dbscan.labels_[i] == 2:
		c4 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#000000',marker=(8, 2))
		cnt4=cnt4+1
	elif dbscan.labels_[i] == 3:
		c5 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#FFFF00',marker=(8, 2))
		cnt5=cnt5+1
	elif dbscan.labels_[i] == 4:
		c6 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#FF5733',marker=(8, 2))
		cnt6=cnt6+1
	elif dbscan.labels_[i] == 5:
		c7 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#88584E',marker=(8, 2))
		cnt7=cnt7+1
	elif dbscan.labels_[i] == 6:
		c8 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#AA4530',marker=(8, 2))
		cnt8=cnt8+1
	elif dbscan.labels_[i] == 7:
		c9 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#572A21',marker=(8, 2))
		cnt9=cnt9+1
	elif dbscan.labels_[i] == 8:
		c10 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#918716',marker=(8, 2))
		cnt10=cnt10+1
	elif dbscan.labels_[i] == 9:
		c11 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#169133',marker=(8, 2))
		cnt11=cnt11+1
	elif dbscan.labels_[i] == 10:
		c12 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#164B91',marker=(8, 2))
		cnt12=cnt12+1
	elif dbscan.labels_[i] == 11:
		c12 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#911675',marker=(8, 2))
	elif dbscan.labels_[i] == 12:
		c13 = pl.scatter(pca_2d[i,0],pca_2d[i,1],c='#91163D',marker=(8, 2))

unique, counts = np.unique(dbscan.labels_, return_counts=True)
clusters=['Noise','C 1','C2','C 3','C4','C 5','C6','C 7','C8','C 9','C10','C 11']
print("Outlier  : ",cnt1)
print("Cluster 1  : ",cnt2)
print("Cluster 2  : ",cnt3)
print("Cluster 3  : ",cnt4)
print("Cluster 4  : ",cnt5)
print("Cluster 5  : ",cnt6)
print("Cluster 6  : ",cnt7)
print("Cluster 7  : ",cnt8)
print("Cluster 8  : ",cnt9)
print("Cluster 9  : ",cnt10)
print("Cluster 10  : ",cnt11)
print("Cluster 11  : ",cnt12)
pl.show()
