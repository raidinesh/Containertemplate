# -*- mode: ruby -*-
# vi: set ft=ruby :

# NOTE: There are two environment variables that this file expects
# to have
# http_proxy -> The http proxy that should be used.

# Some comment

Vagrant.configure(2) do |config|

  # We use a vagrant plugin called proxyconf
  # You install it by 'vagrant plugin install vagrant-proxyconf'
  if Vagrant.has_plugin?("vagrant-proxyconf")
    config.proxy.http     = ENV['http_proxy']
    config.proxy.https    = ENV['http_proxy']
    # Ideally, we would want our entire subnet in no_proxy.
    # However, I've had some problems so I'll just use hostnames
    # for the moment
    config.proxy.no_proxy = "localhost,127.0.0.1"
    # Skip managing the proxy for Docker - there are some known
    # problems with this tool and Docker. For now, skip it.
    config.proxy.enabled = true
    config.proxy.enabled = { docker: false }
  end

  # We use a vagrant plugin called proxyconf
  # You install it by 'vagrant plugin install vagrant-hostmanager'
  if Vagrant.has_plugin?("vagrant-hostmanager")
    config.hostmanager.enabled = true
    config.hostmanager.manage_guest = true
    config.hostmanager.ignore_private_ip = false
    config.hostmanager.include_offline = true
  end  

  config.vm.define "dockerHost" do |vm1|
    vm1.vm.box = "OL7DevBox-1.0.8.box"
    vm1.vm.box_url = "http://usmar-buildserver01.us.oracle.com/boxen/OL7DevBox-1.0.8.box"
    vm1.vm.hostname = "dockerHost"
    # Create a custom forwarded port.
    # Forward a port used by our test drivers to expose results
    vm1.vm.network "forwarded_port", guest: 9080, host: 9080
    # This is used to expose the unencrypted docker port
    vm1.vm.network "forwarded_port", guest: 2375, host: 2375
    # This is used to expose the Java debug ports
    vm1.vm.network "forwarded_port", guest: 8002, host: 8002
    # This is used to expose the main application port
    vm1.vm.network "forwarded_port", guest: 8120, host: 8120
    # This is used to expose the config port
    vm1.vm.network "forwarded_port", guest: 8888, host: 8888
    # This is used to expose the service discovery port
    vm1.vm.network "forwarded_port", guest: 8761, host: 8761

    # The host is .1. Start our servers at .2
    #vm1.vm.network "private_network", ip: "192.168.10.2"
  end

end
