package br.com.rnery;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ProdutoDAOTest.class, ProdutoServiceTest.class})
public class ProdutoAllTests {

}
