/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.setblack.airomem.core;

import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author jratajsk
 */
public class CommandTest {

    private static final String COMMAND_PERFORMED_MARKER = "command performed";

    public CommandTest() {
    }

    @Test
    public void testExecuteWithContext() {
        StorableObject s = StorableObject.createTestObject();
        assertNotSame(COMMAND_PERFORMED_MARKER, s.immutable.get("test"));
        VoidCommand<StorableObject> cmd = x -> x.internalMap.put("test", COMMAND_PERFORMED_MARKER);
        cmd.execute(s, new PrevalanceContext(new Date()));
        assertEquals(COMMAND_PERFORMED_MARKER, s.immutable.get("test"));
    }

}
