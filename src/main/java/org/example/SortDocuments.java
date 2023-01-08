package org.example;

import java.util.HashMap;
import java.util.Map;

public class SortDocuments {
    private final Document[] documents;
    public SortDocuments (Document[] documents) {
        int size = 0;
        if (documents[documents.length - 1] == null) {
            while (documents[size] != null) {
                size++;
            }
        } else {
            size = documents.length;
        }
        Document[] documents1 = new Document[size];
        for (int i = 0; i < size; i++) {
            documents1[i] = documents[i];
        }
        this.documents = Sort(documents1);
    }
    private Document[] Sort(Document[] docs) {
        Map<String, String> map = new HashMap<String, String>();
        int size = docs.length;
        for (int i = 0; i < size; ++i) {
            String parent = docs[i].GetParent();
            if (parent != null) {
                for (int j = i; j < size; j++) {
                    if (parent.equals(docs[j].GetElem())) {
                        Document doc = docs[i];
                        docs[i] = docs[j];
                        docs[j] = doc;
                    }
                }
            }
        }
        return docs;
    }
    public Document[] ReturnSorted() {
        return documents;
    }
}
