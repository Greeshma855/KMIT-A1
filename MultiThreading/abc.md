how will multiple threads access common data?
write your own constructor make the data static and all the threads can access the same data, as ther will be only one static variable for a class.

setdeamon()
Deamond thread is a background thread that provides the necessary services to user/n0n-deamon threads
the user threads can terminate if the daemon thread is still running.

use setdeamon() will terminate all threads when the main ends and using join will allow these deamon threads to run before the main terminates.

MAX_PRIORITY
MIN_PRIORITY
NORM_PRIORITY - The priority which the thread gets from it's parent.

setPriority() will set the priority so that it 

what problems do we need to solve while building a multi threaded application.

locking of resources

what is synchronization? how does it happen?
