package nl.rug.learnclient.test;

import com.google.common.collect.Lists;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CleanUpStack {
    interface CleanUpItem {
        void cleanUp();
    }

    private final List<CleanUpItem> cleanUpStack = new ArrayList<>();

    public void addCleanUp(CleanUpItem closeable) {
        cleanUpStack.add(closeable);
    }

    public void cleanUp() {
        for (var cleanUpItem : Lists.reverse(cleanUpStack)) {
            cleanUpItem.cleanUp();
        }
    }
}
