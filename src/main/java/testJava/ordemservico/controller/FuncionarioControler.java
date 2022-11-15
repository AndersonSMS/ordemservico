package testJava.ordemservico.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import testJava.ordemservico.models.Funcionario;
import testJava.ordemservico.repository.FuncionarioRepository;

@Controller
public class FuncionarioControler {


    /*
    @Autowired JdbcTemplate jdbcTemplate;

    @GetMapping("/listaFuncionarios")
    public List<Funcionario> listaFuncionarios() {
        String sql = "select * from tbl_funcionario;";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Funcionario.class));
    }
 */









    //*
    @Autowired
    private FuncionarioRepository er;

    @RequestMapping(value="/listaFuncionarios", method = RequestMethod.GET)
    public ModelAndView form() {
        Iterable<Funcionario> funcionarios = this.er.findAll();
        ModelAndView mv = new ModelAndView("evento/listaFuncionarios");
        mv.addObject("funcionarios", funcionarios);
        return mv;
        //return "evento/listaFuncionarios";
    }

    @RequestMapping(value="/criarFuncionario", method = RequestMethod.GET)
    public String formCriarFuncionario() {
        return "evento/criarFuncionario";
    }

    @RequestMapping(value="/criarFuncionario", method = RequestMethod.POST)
    public String form(Funcionario func) {
        this.er.save(func);
        return "redirect:/listaFuncionarios";
    }

    @RequestMapping(value="/ordemServico", method = RequestMethod.GET)
    public String formOS() {
        return "evento/ordemServico";
    }

    public FuncionarioRepository getEr() {
        return er;
    }

    public void setEr(FuncionarioRepository er) {
        this.er = er;
    }
    //*/
}