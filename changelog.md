### version 0.0.2

  * RESTful support. Example with grid/clusters resources.
  
   `GET /1.0` : get the grid information

   `GET /1.0/clusters` : get all clusters
   
   `POST /1.0/clusters` : create a new cluster (body : name of the cluster)
   
   `DELETE /1.0/clusters/{clusterId}` : delete the cluster with Id clusterId.
   
   `GET /1.0/clusters/{clusterId}` : get the cluster whose id is clusterId 

### version 0.0.1

  * initial version. Say hello on http://localhost:4001
