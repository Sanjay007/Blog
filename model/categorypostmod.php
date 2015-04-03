<?php

class Categorypostmod extends CI_Model {
	function __construct() {
    parent::__construct();
    $this->load->database();
    }
	 
function getCategorycount($catname){
$this->db->select('*');
$this->db->from('post');
$this->db->like('tags', $catname);
return $this->db->count_all_results();	
}

function getCategorypost($catname,$lim1,$lim2){
$this->db->select('*')->from('post')->like('post.tags',$catname)->limit($lim1, $lim2);
$query = $this->db->get();
return $query;
}
		
	
}
