# Set Cloudata-specific environment variables here.
# JAVA_HOME, CLOUDATA_HOME, HADOOP_HOME required

heapsize() {
  echo " -Xms$1""m"" -Xmx$2""m "
}

#JAVA HOME dir
#export JAVA_HOME=/usr/java/jdk1.6.0_06
export JAVA_HOME=/System/Library/Frameworks/JavaVM.framework/Versions/1.6.0/Home

#Cloudata home dir
#export CLOUDATA_HOME=/home/cloudata
export CLOUDATA_HOME=/Users/babokim/workspace/cloudata

#Neptune conf dis
export CLOUDATA_CONF_DIR="${CLOUDATA_HOME}/conf"

# JVM Heap Size (MB) of each Neptune component
#export CLOUDATA_MASTER_HEAPSIZE=`heapsize 512 1024`
#export CLOUDATA_TABLETSERVER_HEAPSIZE=`heapsize 2048 2048`
#export CLOUDATA_COMMITLOGSERVER_HEAPSIZE=`heapsize 512 512`

export CLOUDATA_MASTER_HEAPSIZE=`heapsize 64 1024`
export CLOUDATA_TABLETSERVER_HEAPSIZE=`heapsize 64 2048`
export CLOUDATA_COMMITLOGSERVER_HEAPSIZE=`heapsize 64 512`

# TABLET_SERVER JMX Socket Port
export TABLETSERVER_JMX_PORT=58000

# Extra Java CLASSPATH elements.  Optional.
#export CLOUDATA_CLASSPATH=

# The directory where pid files are stored. /tmp by default.
export CLOUDATA_PID_DIR=~/.cloudata_pids

# A string representing this instance of cloudata. $USER by default.
# export CLOUDATA_IDENT_STRING=$USER

#ZooKeeper dir
export ZOOKEEPER_HOME=/home/zookeeper
export ZOOKEEPER_CONF=${ZOOKEEPER_HOME}/conf/zoo.cfg

# Hadoop Home dir
#export HADOOP_HOME=/home/hadoop
export HADOOP_HOME=/Users/babokim/work/program/hadoop-0.20.2

# Hadoop Conf dir
export HADOOP_CONF_DIR="${HADOOP_HOME}/conf"

# JVM Options of each Neptune component
export CLOUDATA_MASTERNODE_OPTS="$CLOUDATA_MASTER_HEAPSIZE -Dcom.sun.management.jmxremote"
export CLOUDATA_TABLETSERVER_OPTS="-XX:+UseConcMarkSweepGC -XX:+ExplicitGCInvokesConcurrent -XX:+CMSClassUnloadingEnabled -XX:CMSInitiatingOccupancyFraction=50 -server -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.port=$TABLETSERVER_JMX_PORT $CLOUDATA_TABLETSERVER_HEAPSIZE"
export CLOUDATA_COMMITLOG_OPTS="-XX:+UseConcMarkSweepGC -XX:+ExplicitGCInvokesConcurrent -XX:+CMSClassUnloadingEnabled -XX:CMSInitiatingOccupancyFraction=50 -server $CLOUDATA_COMMITLOGSERVER_HEAPSIZE"
