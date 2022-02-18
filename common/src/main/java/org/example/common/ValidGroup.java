package org.example.common;

import javax.validation.groups.Default;

/**
 * @author : zhicheng chen
 * @date : 2022/2/18
 * @time : 16:07
 */
public interface ValidGroup extends Default {
    interface Crud extends ValidGroup{
        interface Create extends Crud{

        }

        interface Update extends Crud{

        }

        interface Query extends Crud{

        }

        interface Delete extends Crud{

        }

        interface QueryStatement extends Crud{

        }

        interface SaveStatement extends Crud{

        }
    }
}
