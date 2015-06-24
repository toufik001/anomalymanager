/**
 * 
 */
package com.gnu.anomalymanager.manager.impl;

import org.springframework.transaction.annotation.Transactional;

import com.gnu.anomalymanager.bo.Agent;

/**
 * @author Baz Taoufik
 *
 */
@Transactional
public class AgentManagerImpl extends SimpleManagerImpl<Agent, Long>{

}
