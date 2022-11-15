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

    @Autowired
    private FuncionarioRepository er;

    @RequestMapping(value="/listaFuncionarios", method = RequestMethod.GET)
    public ModelAndView form() {
        //Ler todos os funcionários para apresentar na tela listaFuncionarios
        Iterable<Funcionario> funcionarios = this.er.findAll();
        ModelAndView mv = new ModelAndView("evento/listaFuncionarios");
        mv.addObject("funcionarios", funcionarios);
        return mv;

    }

    @RequestMapping(value="/criarFuncionario", method = RequestMethod.GET)
    public String formCriarFuncionario() {
        //redirecionar para o cadastro de funcionário
        return "evento/criarFuncionario";
    }

    @RequestMapping(value="/criarFuncionario", method = RequestMethod.POST)
    public String form(Funcionario func) {
        //Salvar funcionário no bando de dados
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
}