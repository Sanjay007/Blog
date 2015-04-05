<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class CategoryPost extends CI_Controller {

  

	
	function viewcategory($name)
{
This is a second change
 $this->load->();
 fgfgfggtgtthyhyhyjhjujujuj

    $this->load->helper("url");
    $this->load->helper('form');

    $this->load->library('table');
    $this->load->library('pagination');

    $this->load->model('categorypostmod');
    $this->load->model("site_model");

    $page = $this->uri->segment(5);
    $categCount = $this->categorypostmod->getCategorycount($name);

    $config['base_url'] = "http://localhost/b3/index.php/CategoryPost/viewcategory/" . $name . "/page/";
    $config['per_page'] = 2;
    $config['num_links'] = 5;

    log_message('info', 'count is ' . $categCount);

    $config['total_rows'] = $categCount;
    $config['full_tag_open'] = '<ul class="pagination">';

    $config['full_tag_close'] = '</ul>';

    $config['use_page_numbers'] = TRUE;

    $config['next_link'] = 'Next';
    $config['next_tag_open'] = '<li class="next page">';
    $config['next_tag_close'] = '</li>';

    $config['prev_link'] = ' Previous';
    $config['prev_tag_open'] = '<li class="prev page">';
    $config['prev_tag_close'] = '</li>';

    $config['cur_tag_open'] = '<li class="active"><a href="">';
    $config['cur_tag_close'] = '</a></li>';

    $config['num_tag_open'] = '<li class="page">';
    $config['num_tag_close'] = '</li>';

    $data['query'] = $this->categorypostmod->getCategorypost($name, $config['per_page'], $page);

  //  $records = $this->db->get('post', $config['per_page'], $page);

    $this->pagination->initialize($config);


    $this->load->view('script');
    $this->load->view('head');
    $this->load->view('cat_content_list', $data);

    $this->load->view('aside');
    $this->load->view('bottom');
}



}	
/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */
