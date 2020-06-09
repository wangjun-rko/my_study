package com.wj88.lucene.index;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * Indexer
 *
 * @author huayu
 * @version 1.0
 * @description 索引
 * @date 2019/11/28 16:55
 */
public class Indexer {

    /**写索引实例**/
    private IndexWriter writer;

    public Indexer(String indexDir) throws Exception {
        Directory directory = FSDirectory.open(Paths.get(indexDir));
        /**标准分词器 会自动去掉空格 is a the 等单词**/
        Analyzer analyzer = new StandardAnalyzer();
        /**将标准分词器配到写索引的配置中**/
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        /**实例化写索引对象**/
        writer = new IndexWriter(directory,indexWriterConfig);
    }

    /**
     * @Description 索引指定目录下的所有文件
     * @Param [dir]
     * @return int
     * @Author huayu
     * @date 2019/11/28 17:13
     */
    public int indexAll(String dir) throws Exception {
        File[] files = new File(dir).listFiles();
        for (File file:files){
            indexFile(file);
        }
        // 返回索引的文件数
        return writer.numDocs();
    }

    /**
     * @Description 索引指定文件
     * @Param [file]
     * @return void
     * @Author huayu
     * @date 2019/11/28 17:12
     */
    private void indexFile(File file) throws Exception {
        System.out.println("索引文件路径："+file.getCanonicalPath());
        Document doc = getDocument(file);
        // 将doc文件添加到索引中
        writer.addDocument(doc);
        writer.commit();
    }

    /**
     * @Description 获取文档 文档里再设置每个字段 类似于数据库中的一行记录
     * @Param [file]
     * @return org.apache.lucene.document.Document
     * @Author huayu
     * @date 2019/11/28 17:10
     */
    private Document getDocument(File file) throws Exception {
        Document doc =new Document();
        // 添加内容
        doc.add(new TextField("contents",new FileReader(file)));
        // 添加文件名 并把这个字段存到索引文件里
        doc.add(new TextField("fileName",file.getName(), Field.Store.YES));
        // 添加文件路径
        doc.add(new TextField("fullPath",file.getCanonicalPath(), Field.Store.YES));
        System.out.println(doc.get("fullPath"));
        System.out.println(doc.get("fileName"));
        System.out.println(doc.get("contents"));
        return doc;
    }

    public static void main(String[] args) {
        String indexDir = "D:\\logs\\luncene";
        String dataDir = "D:\\logs\\luncene\\data";
        Indexer indexer = null;
        int indexedNum = 0;
        long startTime = System.currentTimeMillis();
        try{
            indexer = new Indexer(indexDir);
            indexedNum = indexer.indexAll(dataDir);
        } catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("索引耗时："+(endTime-startTime)+" 毫秒");
        System.out.println("共索引了："+indexedNum+" 个文件");
    }
}
