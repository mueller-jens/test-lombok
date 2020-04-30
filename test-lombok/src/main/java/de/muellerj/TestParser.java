package de.muellerj;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.sun.source.tree.IfTree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;

public class TestParser extends TreePathScanner<Void, Trees> {

	public static void main(String[] args) throws IOException, URISyntaxException {
		System.out.println("/de/muellerj/EqualsAndHashCodeExample.java");
		new TestParser().run(new File(TestParser.class.getResource("/de/muellerj/EqualsAndHashCodeExample.java").toURI()).getPath());
		System.out.println("--------------");
		System.out.println("/de/muellerj/EqualsAndHashCodeExampleExplizitEquals.java");
		new TestParser().run(new File(TestParser.class.getResource("/de/muellerj/EqualsAndHashCodeExampleExplizitEquals.java").toURI()).getPath());
		System.out.println("--------------");
	}
	
	public void run(String sourceFile) throws IOException, URISyntaxException {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, Locale.ENGLISH, Charset.forName("UTF-8"));
		
		ArrayList<String> sourceFileNames = new ArrayList<>();
		sourceFileNames.add(sourceFile);
		
		List<JavaFileObject>  sourceFiles = iterableToList( fileManager
				.getJavaFileObjectsFromStrings(sourceFileNames));
		JavacTask task = ((JavacTask)compiler.getTask(null, fileManager, null, null, null, sourceFiles));
		Iterable elements = task.parse(); 
		task.analyze();
		super.scan(elements, Trees.instance(task));
		
	}
	public static <T> List<T> iterableToList(Iterable<? extends T> iterable) {
		List<T> result = new ArrayList<T>();
		iterable.forEach(result::add);
		return result;
	}
	
	@Override
	public Void visitIf(IfTree ifStatement, Trees trees) {
		System.out.println(ifStatement.getCondition());
		return null;
	}
	
}
