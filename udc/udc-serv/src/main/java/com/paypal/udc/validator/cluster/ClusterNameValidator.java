package com.paypal.udc.validator.cluster;

import org.springframework.stereotype.Component;
import com.paypal.udc.entity.Cluster;
import com.paypal.udc.exception.ValidationError;


@Component
public class ClusterNameValidator implements ClusterValidator {

    private ClusterValidator chain;

    @Override
    public void setNextChain(final ClusterValidator nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void validate(final Cluster cluster, final Cluster updatedCluster) throws ValidationError {
        if (cluster.getClusterName() != null && cluster.getClusterName().length() >= 0) {
            updatedCluster.setClusterName(cluster.getClusterName());
        }
        this.chain.validate(cluster, updatedCluster);
    }

}
