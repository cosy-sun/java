package com.cosy.sun.batch;//package com.cosy.sun.test;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobParameters;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.launch.JobOperator;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.Date;
//import java.util.Iterator;
//import java.util.Set;
//
//public class JobLauncherTest {
//
//	public static  void main(String[] args) throws Exception {
////		new JobLauncherTest().testMemory();
////		new JobLauncherTest().testDb();
////		new JobLauncherTest().testParameters();
////		new JobLauncherTest().testAbstract();
////		new JobLauncherTest().testLateBinding();
////		new JobLauncherTest().testAsync();
////		new JobLauncherTest().testStop();
////		testStepAbstract();
////		testCountAndRestartTasklet();
////		testTaskletTransactionRollback();
////		testExecutor();
////		testTaskletCustomer();
////		testTaskletAdapter();
////		testChunkskip();
////		testChunkRetry();
////		testReader();
////		testXml();
////		testMult();
////		testJdbc();
//		testwriter();
//	}
//
//	public static void testwriter() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_write_xml.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("billJob123");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testJdbc() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_db_jdbc.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("jdbcJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testMult() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_reader_Mult_resource.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("billJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testXml() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_reader_xml.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("billJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testReader() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_reader_flatfileitemreader.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("billJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testChunkCompletion() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_chunk_completion.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("subJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testChunkRetry() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_chunk_retry.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("subJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testChunkskip() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_chunk_exception_skip_count.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("subJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testTaskletAdapter() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_tasklet_adapter.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("cust");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testTaskletCustomer() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_tasklet_customer.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("cust");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testExecutor() throws Exception{
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_step_executor.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("subJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//
//	}
//
//	public static void testTaskletTransactionRollback() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_tasklet_transaction_rollback.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("subJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testCountAndRestartTasklet() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_tasklet_restart_and_count.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("subJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public static void testStepAbstract() throws Exception {
//		// 在这个配置文件中加入了stepListener和listener合并以及stepParent
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_abstract_step.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("billJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println("***" + run.toString());
//	}
//
//	public void testStop() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_jmx_operator.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		JobOperator jobOperator = (JobOperator) context.getBean("jobOperator");
//		Job job = (Job) context.getBean("subJob");
//		JobParametersBuilder parameter =
//				new JobParametersBuilder()
//				.addDate("date", new Date())
//				.addString("name", "sunzhenhua")
//				.addString("hahaha", "hahahahaha")
//				.addDate("createtime", new Date());
////				.addString("inputResource", "classpath:ch02/data/credit-card-bill-201303.csv");
//		JobExecution run = joblauncher.run(job, parameter.toJobParameters());
//		Thread.sleep(1000);
//		System.out.println("*******************");
//		System.out.println(run.toString());
//		Set<Long> runningExecutions = jobOperator.getRunningExecutions("subJob");
//		Iterator<Long> iterator = runningExecutions.iterator();
//		while(iterator.hasNext()) {
//			long executionId = iterator.next();
//			boolean stop = jobOperator.stop(iterator.next());
//			System.out.println(jobOperator.getParameters(executionId).toString());
//			System.out.println("*****message: " + stop);
//		}
//	}
//
//	/**
//	 * 异步joblauncher
//	 * @throws Exception
//	 */
//	public void testAsync() throws Exception{
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_async.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("subJob");
//		JobParametersBuilder parameter =
//				new JobParametersBuilder()
//				.addDate("date", new Date())
//				.addString("name", "sunzhenhua")
//				.addString("hahaha", "hahahahaha")
//				.addDate("createtime", new Date());
////				.addString("inputResource", "classpath:ch02/data/credit-card-bill-201303.csv");
//		JobExecution run = joblauncher.run(job, parameter.toJobParameters());
//		System.out.println("******"+run.toString());
//	}
//
//	public void testLateBinding() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_late_binding.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("subJob");
//		JobParametersBuilder parameter =
//				new JobParametersBuilder()
//				.addDate("date", new Date())
//				.addString("name", "sunzhenhua")
//				.addString("hahaha", "hahahahaha")
//				.addDate("createtime", new Date())
//				.addString("inputResource", "classpath:ch02/data/credit-card-bill-201303.csv");
//		JobExecution run = joblauncher.run(job, parameter.toJobParameters());
//		System.out.println(run.toString());
//	}
//
//	public void testMemory() throws Exception{
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("billJob");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println(run.toString());
//	}
//
//	public void testDb() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_db.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("billJob1");
//		JobExecution run = joblauncher.run(job, new JobParameters());
//		System.out.println(run.toString());
//	}
//
//	public void testParameters() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_db.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("billJob1");
//		JobParametersBuilder parameter =
//				new JobParametersBuilder()
//				.addDate("date", new Date())
//				.addString("name", "sunzhenhua")
//				.addString("hahaha", "hahahahaha")
//				.addDate("createtime", new Date());
//		JobExecution run = joblauncher.run(job, parameter.toJobParameters());
//		System.out.println(run.toString());
//	}
//
//	public void testAbstract() throws Exception {
//		@SuppressWarnings("resource")
//		ApplicationContext context = new ClassPathXmlApplicationContext("ch02/job/job_abstract.xml");
//		JobLauncher joblauncher = (JobLauncher) context.getBean("jobLauncher");
//		Job job = (Job) context.getBean("subJob");
//		JobParametersBuilder parameter =
//				new JobParametersBuilder()
//				.addDate("date", new Date())
//				.addString("name", "sunzhenhua")
//				.addString("hahaha", "hahahahaha")
//				.addDate("createtime", new Date());
//		JobExecution run = joblauncher.run(job, parameter.toJobParameters());
//		System.out.println(run.toString());
//	}
//
//}
