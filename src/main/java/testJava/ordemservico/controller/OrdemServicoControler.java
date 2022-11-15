package testJava.ordemservico.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import testJava.ordemservico.models.OrdemServico;
import testJava.ordemservico.repository.OrdemServicoRepository;

@Controller
public class OrdemServicoControler {


    /*
    @Autowired JdbcTemplate jdbcTemplate;

    @GetMapping("/listaFuncionarios")
    public List<Funcionario> listaFuncionarios() {
        String sql = "select * from tbl_funcionario;";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Funcionario.class));
    }
 */


   
    @Autowired
    private OrdemServicoRepository er;

     

    @RequestMapping(value="/listaOrdensServico", method = RequestMethod.GET)
    public ModelAndView form() {
        Iterable<OrdemServico> ordensServico = this.er.findAll();
        ModelAndView mv = new ModelAndView("evento/listaOrdensServico");
        mv.addObject("ordensServico", ordensServico);
        return mv;
        //return "evento/listaFuncionarios";
    }

 

    @RequestMapping(value="/criarOrdemServico", method = RequestMethod.POST)
    public String form(OrdemServico oS) {
       
        int maior =0;
        //pegar o funcionario atual
        oS.setFuncionario("0812038782");
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    Date date = new Date();
        oS.setData_inicio(date);
        oS.setStatus_os("Aberto");
        Iterable<OrdemServico> ordensServico = this.er.findAll();
        for (OrdemServico ordemServico : ordensServico) {
            if (maior < ordemServico.getCodigo()){
                maior=ordemServico.getCodigo();
            }
        }
        oS.setCodigo(maior+1);
        this.er.save(oS);
        return "redirect:/listaOrdensServico";
    }



    @RequestMapping(value="/criarOrdemServico", method = RequestMethod.GET)
    public String formCriarOrdemServico() {
        return "evento/criarOrdemServico";
    }

    @RequestMapping(value="/appOrdemServico", method = RequestMethod.GET)
    public String appOrdemServico() {
        return "evento/appOrdemServico";
    }
    /*

    @RequestMapping(value="/ordemServico", method = RequestMethod.GET)
    public String formOS() {
        return "evento/ordemServico";
    }

    public OrdemServicoRepository getEr() {
        return er;
    }

    public void setEr(OrdemServicoRepository er) {
        this.er = er;
    }
    /*/
}