package com.wj88.lucene.index;

import java.nio.file.Paths;

import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * ChineseIndexer
 *
 * @author huayu
 * @version 1.0
 * @description 中文索引
 * @date 2019/11/28 18:11
 */
public class ChineseIndexer {

    // 存放索引位置
    private Directory dir;

    private int[] ids ={1,2,3};
    private String[] names = {"试试","嗯嗯","力量"};
    private String[] des = {"单独试试傻傻的阿大声道","发的嗯嗯与","为力量灌灌灌灌"};

    /**
     * @Description 生成索引
     * @Param [indexDir]
     * @return void
     * @Author huayu
     * @date 2019/11/28 18:23
     */
    public void index(String indexDir) throws Exception {
        dir = FSDirectory.open(Paths.get(indexDir));
        IndexWriter writer = getWriter();
        for (int i=0;i<ids.length;i++){
            Document doc = new Document();
            // 生成索引
            doc.add(new IntField("id",ids[i], Field.Store.YES));
            doc.add(new StringField("name",names[i], Field.Store.YES));
            doc.add(new TextField("des",des[i], Field.Store.YES));
            // 添加文档
            writer.addDocument(doc);
        }
        // close才真正写到文档中
        writer.close();
    }

    private IndexWriter getWriter() throws Exception {
        // 使用中文分词器
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        // 将分词器配到写索引的配置中
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        // 实例化写索引对象
        IndexWriter writer = new IndexWriter(dir,config);
        return writer;
    }

    public static void main(String[] args) throws Exception {
        new ChineseIndexer().index("D:\\logs\\luncene\\ch");
    }
}
